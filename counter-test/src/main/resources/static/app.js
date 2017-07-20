var stompClient = null;

function connect() {
    var socket = new SockJS('/click-counter-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/greetings', function (counter) {
            updateCounter(JSON.parse(counter.body));
        });
    });
    waitForSocketConnection(stompClient, getCounterValue);
}


function waitForSocketConnection(socket, callback){
    setTimeout(
        function () {
            if (socket != null && socket.connected === true) {
                console.log("Connection is made")
                if(callback != null){
                    callback();
                }
                return;

            } else {
                console.log("wait for connection...")
                waitForSocketConnection(socket, callback);
            }
        }, 5);
}

function disconnect() {
    if (stompClient != null && stompClient.connected == true) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function getCounterValue() {
    stompClient.send("/app/countervalue", {}, null);
}

function click() {
    stompClient.send("/app/counterincrement", {}, null);
}

function updateCounter(message) {
	document.getElementById("counter").innerHTML = message;
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { click(); });
});