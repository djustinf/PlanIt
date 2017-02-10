const http = require('http');
const fs = require('fs');
const jwt = require('jwt-simple');
var mysql      = require('mysql');

const port = 3000;

var secret = undefined, dbPassword = undefined;

var secretObj = JSON.parse(fs.readFileSync("res/secret.json").toString());
secret = secretObj.secret;
dbPassword = secretObj.dbPassword;
if(!secret || !dbPassword){
    throw "missing dbPassword or JWT secret, will not run";
} 


var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : dbPassword,
    database : 'ThinkInc'
});

connection.connect();

connection.query('SELECT * FROM Users', function (error, results, fields) {
    if (error) throw error;
    console.log("There are " + results.length + " users in the database");
    results.forEach(function(result){
	console.log(result.userID + ") " + result.firstName + " " + result.lastName + " " + result.email);  
    });
});


const requestHandler = function(request, response){
    if(request.method == 'POST'){
	var data;
	request.on('data', function(chunk){
	    console.log("received body data");
	    console.log(chunk.toString());
	    try{
		data = JSON.parse(chunk.toString());
		console.log(data);
	    }catch(e){
		console.log(e);
		response.writeHead(500, {
		    'Content-Type': 'text/plain',
		    'Access-Control-Allow-Origin': '*'
		});
		return response.end("Internal Error");
	    }
	    console.log(chunk.toString());
	    if(request.url == "/user/signin"){
		return signinUser(data, response);
	    }
	    else{
		resposne.writeHead(406, {'Content-Type': 'text/plain'});
		return response.end("endpoint not supported");
	    }

	});
	
    }
    else if(request.method == "GET"){
	console.log("this is a test get");
	var isAuthorized = checkJWT(request);
	console.log(isAuthorized);
	if(isAuthorized){
	    //var remainingHours = isAuthorized / (1000 * 60 * 60);
	    //var remainingMinutes = isAuthorized % remainingHours / (1000 * 60);
	    //var remainingSeconds = isAuthorized % remainingHours % remainingMinutes / (1000 * 60);
	    
	    //var remainingTimeStr = remainingHours + ":" + remainingMinutes + ":" + remainingSeconds;
	    //console.log(remainingTimeStr);
	    response.writeHead(200, {'Content-Type': 'text/plain'});
	    response.end("you are still authorized"); // + remainingTimeStr);
	} else {
	    response.writeHead(406, {'Content-Type': 'text/plain'});
	    response.end("unauthorized");
	}
    }
    else {
	response.writeHead(406, {'Content-Type': 'text/plain'});
	return response.end("GET request not supported");
    }
}

function checkJWT(req){
    var token = (req.body && req.body.access_token) || (req.query && req.query.access_token) || req.headers['x-access-token'];
    if (token) {
	try {
	    var decoded = jwt.decode(token, secret);
	    console.log(decoded.exp);
	    if(decoded.exp <= Date.now()){
		console.log("token is expired");
		return false;
	    }
	    console.log("made it" + decoded.exp + " " + Date.now());
	    return true;
	    //	    return new Date(decoded.exp).UTC * 1 - Date.now();
	} catch (err) {
	    console.log(err);
	    return false;
	}
    } else {
	console.log("No JWT present in request");
	return false;
    }
}

function signinUser(postData, response){
    console.log('this is the right endpoint');
    var username, password;
    if(!postData){
	response.writeHead(400, {'Content-Type': 'text/plain'});
	return response.end("missing body");
    }
    username = postData.username;
    password = postData.password;
    if(!username || !password){
	console.log("Here1");
	response.writeHead(400, {'Content-Type': 'text/plain'});
	return response.end("missing username or password");		
    }
    var userExistsAndValid = false;
    var whichUser = undefined;
    connection.connect();

    connection.query("SELECT * FROM Users WHERE email=" + username + " AND password=" + password,
		     function(error, results, fields){
			 if(error){
			     response.writeHead(500, {'Content-Type': 'text/plain'});
			     return response.end(error);
			 }
			 
			 if(!results.length){
			     response.writeHead(400, {'Content-Type': 'text/plain'});
			     return response.end("username or password is incorrect");
			 }

			 //Generate JWT
			 var expires = new Date() + (1000 * 60 * 60 * 24);
			 var token = jwt.encode({
			     iss: username,
			     exp: expires
			 }, secret);
			 
			 var toRespond = {
			     token : token,
			     expires: expires,
			     userID: results[0].userID,
			     firstName: results[0].firstName,
			     lastName: results[0].lastName,
			     email: results[0].email
			 };

			 connection.end()
			 response.writeHead(200, {'Content-Type': 'application/json'});
			 return response.end(JSON.stringify(toRespond));
		     });
    
}

const server = http.createServer(requestHandler);

server.listen(port, function(err){
    if(err)
	console.log(err);
    
    console.log("server is listening on " + port);
});
