
//
// server.cc
//
// A simple tcp/ip socket-based server.
//   Handles exactly one connection and one request
//

// System include's
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <iostream>
#include <string.h>
#include <stdio.h>
#include <pthread.h>
// App include's
#include "message.h"


#define BUFFERSIZE	512
#define NTHREADS	100
#define SERVER_PORT 6001
#define POOL_SIZE 5

void *main_client_thread(void *arg);
int serarch(int requestID);
void addrequestID(int requestID );
void removerequestID(int requestID);

typedef struct mainthreadArg
{
	int csocketId;
	int threadCounter;
}mtArg;

int request_ID[NTHREADS]={-1};

// Default port number if user does not specify it
#define DEFAULT_PORT_NUMBER "2000"

using namespace std;

int main(int argc, char** argv )
{
   int sockdesc;            // Socket descriptor
   struct addrinfo *myinfo; // Address record
   char portnum[81];        // Port number
   int connection;          // Return value from accept( )
   char c;                  // Use connection, not sockdesc, for read/write
   int value;               // Return from read( )
  pthread_t cthread[NTHREADS];
   
   
   message mymessage;       // One message record

  

   // Create the socket with domain, type, protocol as
   //    internet, stream, default
   sockdesc = socket(AF_INET, SOCK_STREAM, 0);
   if ( sockdesc < 0 )
   {
      cout << "Error creating socket" << endl;
      exit(0);
   } // if


    while ( (c = getopt(argc, argv, "p:")) != -1 ) {
      switch (c) {
         case 'p': strcpy(portnum, optarg);
                   break; 

      }; // switch
   
   } 
   
   while(true)
   {
   // Set up the address record for this machine
   if ( getaddrinfo("0.0.0.0", portnum, NULL, &myinfo) != 0 )
   {
      cout << "Error getting address" << endl;
      exit(0);
   } // if

   // Bind the socket to an address
   if (bind(sockdesc, myinfo->ai_addr, myinfo->ai_addrlen) < 0 )
   {
      int port = atoi(portnum)+1;
	  sprintf(portnum,"%d\n",port); 
   } // if
   else
   {
    printf("Portnumber:%s\n",portnum);
    break;
   }
  } //while
   // Now listen to the socket
   if ( listen(sockdesc, 1) < 0 )
   {
      cout << "Error in listen" << endl;
      exit(0);
   } // if

   // Note: this loop is typical of servers that accept multiple
   // connections on the same port - normally, after accept( )
   // returns, you'd fork off a process to handle that request, or
   // create a thread to do the same, passing the returned value as
   // a parameter for read( ) and write( ) to use -
   // that is, accept( ) returns a new descriptor - 
   // you actually talk on a different socket in the child.
   // The main program would then loop around, and wait at accept( )
   // for another request for a connection, then hand that new
   // connection off to a child or thread, etc.
   // So the server runs forever - see the for loop parameters -
   // well, until you kill it manually.  Here, we break from
   // the for loop after one message.

   
    mtArg ta;
	ta.threadCounter = 0;   /* thread counter */  
   
   for(;;)
   {
      cout << "Calling accept" << endl;
      // Accept a connect, check the returned descriptor
      connection = accept(sockdesc, NULL, NULL);
      if ( connection < 0 )
      {
         cout << "Error in accept" << endl;
         exit(0);
      }
      else
      {

         // Here's where the fork( ) or pthread_create( ) call would
         // normally go, passing connection (returned by accept( )
         // above) as a parameter.  connection is a file descriptor
         // attached to a different port, so that the server can
         // continue to accept connections on the original port.
         //
         // Instead of all that, this program just does the
         // following:
         // Read exactly one message
         // Note that the first parameter of read is the returned
         // value from accept( ) above.
		 
		 
		ta.csocketId = connection;
	   if( ( pthread_create(&cthread[ta.threadCounter], NULL, main_client_thread, &ta)  ) != 0)
		{
			printf("pthread was not created\n");
			exit(0);
		}
		ta.threadCounter++;

      } // if

   } // for

   // Close the connection
   close(connection);
   return 0;

} // main( )

void *main_client_thread(void *arg)
{
	mtArg t = *(mtArg *)arg;
	int cli,cnt,value;
	cli = t.csocketId;
	cnt = t.threadCounter;
	message mymessage;
	serviceRequest requestinfo;
	
	  while(true)
        {

         if( requestinfo.requestType == 0)
          {		 
		   value = read(cli, (char*)&requestinfo, sizeof(serviceRequest));

           cout<< "requestType :" << requestinfo.requestType << endl;

		   
		   if( serarch(requestinfo.requestID) == 1)
		      addrequestID(requestinfo.requestID );
			  
		   requestinfo.requestType = 3;
		   write(cli, (char*)&requestinfo, sizeof(serviceRequest));
		  }
		 else 
		 {
		     
			 read(cli, (char*)&requestinfo, sizeof(serviceRequest));
		     if( requestinfo.requestType == 2 )
			  {
			    cout<< "requestType :" << requestinfo.requestType << endl;
			    requestinfo.requestType = 3; 
		        write(cli, (char*)&requestinfo, sizeof(serviceRequest));
			  }
			  else
			  {
			     if(requestinfo.requestID == 1)
                   removerequestID(requestinfo.requestID);  
				close(cli);
				break;
			  }
		  	 
		 }
		 
	    }
	return NULL;
}

int serarch(int requestID)
{
   for(int i=0;i<NTHREADS;i++)
      if(requestID == request_ID[i])
	   return 1;
  return 0;
}

void addrequestID(int requestID )
{
   for(int i=0; i<NTHREADS;i++)
     if(request_ID[i] == -1)
	   {
	     request_ID[i] = requestID;
         break;		 
	   }
}

void removerequestID(int requestID)
{
    for(int i=0;i<NTHREADS;i++)
      if(requestID == request_ID[i])
	  {
	   request_ID[i] = -1;
	   break;
	  }
}