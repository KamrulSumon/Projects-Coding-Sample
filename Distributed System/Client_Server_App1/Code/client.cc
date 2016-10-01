//
// client.cc
// 
// Example of a simple tcp/ip socket-based client
//

// System include's
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <iostream>
#include <string.h>
#include <stdio.h>
// Put app include's after system include's
#include "message.h"

using namespace std;

// Port number if the user does not specify it
#define DEFAULT_PORT_NUMBER "2000"
#define HOST "Kamrul"


int main(int argc, char** argv)
{
   struct addrinfo *myinfo; // Address record
   int sockdesc;            // Socket number (*not* the port number)
   char hostname[81];       // Server name
   char portnum[81];        // Server port number (note: char*, not int)
   int connection;          // Return value from connect( )
   int value;               // Return value from read( )
   char c;
   serviceRequest requestinfo;
   
   message mymessage;       // Record for data

   // Startup: specify the server name and optional port number

   
   

   if ( argc == 1 )
   {
      cout << "Usage: client <host> [<portnum>]" << endl;
      exit(0);
   } // if

   // Grab the server naem
   
   strcpy(requestinfo.domainName, HOST );
   requestinfo.requestID = 500;

     while ( (c = getopt(argc, argv, "s:p:")) != -1 ) {
      switch (c) {
         case 'p': strcpy(portnum, optarg);
              		break; 
         case 's': strcpy(hostname, optarg); 
                    break;		 
      }; // switch
      
   } 
 
   // Use AF_UNIX for unix pathnames instead
   // Use SOCK_DGRAM for UDP datagrams
   cout << "Debug: Before socket" << endl;
   sockdesc = socket(AF_INET, SOCK_STREAM, 0);
   if ( sockdesc < 0 )
   {
      cout << "Error creating socket" << endl;
      exit(0);
   }

   // Set up the address record
   cout << "Debug: Before getaddrinfo" << endl;
   if ( getaddrinfo(hostname, portnum, NULL, &myinfo) != 0 )
   {
      cout << "Error getting address" << endl;
      exit(0);
   }

   // Connect to the host
   cout << "Debug: Before connect" << endl;
   connection = connect(sockdesc, myinfo->ai_addr, myinfo->ai_addrlen);
   if ( connection < 0 )
   {
      cout << "Error in connect" << endl;
      exit(0);
   }
   cout << "Debug: Client connection = " << connection << endl;

   requestinfo.requestType=0;   
   write(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   // Read back exactly one message
   value = read(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   cout<<"Server Response: "<< requestinfo.requestType << endl;
  
   requestinfo.requestType=2;   
   write(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   // Read back exactly one message
   value = read(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   cout<<"Server Response: "<< requestinfo.requestType << endl;
   
   requestinfo.requestType=1;   
   write(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   // Read back exactly one message
   value = read(sockdesc, (char*)&requestinfo, sizeof(serviceRequest));
   
      
   // Close the socket
   close(sockdesc);

   return 0;

} // main( )

