# Setup

Build and run app on Android device. You will need to modify `.\android\app\src\main\java\com\example\okhttpdemo\TestRequestTask.java` with the correct url for the nodejs process (consider using nrgok). This file also contains the OkHttpClient timeout settings.


```
cd http-server-test
yarn install
node index.js
```

# Notes

The Nodejs server has 2 endpoints:
```
POST /
    Returns 'Hello World!' right away.

POST /late
    Returns 'Hello World!' after 1.5 minutes.
```

When making a request to the nodejs server, after 31sec, this message comes back:

```
 <HTML>
    <HEAD>
    <TITLE>Inactivity Timeout</TITLE>
    </HEAD>
    
    <BODY BGCOLOR="white" FGCOLOR="black">
    <H1>Inactivity Timeout</H1>
    <HR>
    
    <FONT FACE="Helvetica,Arial"><B>
    Description: Too much time has passed without sending any data for document. 
    </B></FONT>
    <HR>
    </BODY>
```