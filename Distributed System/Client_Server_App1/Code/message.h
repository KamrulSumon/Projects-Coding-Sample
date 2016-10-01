#ifndef MESSAGE_H
#define MESSAGE_H

//
// message.h
//
// Defines a simple struct to hole a message 

// Message record
struct message {
   int    ivalue;     // Some int
   double dvalue;     // Some double
   char   cvalue[56]; // Some string
};

struct serviceRequest
{
   char domainName[256];
   int portNumber;
   int requestType;
   char requestString[32];
   int requestID;
   char payload[256];
 
};

#endif

