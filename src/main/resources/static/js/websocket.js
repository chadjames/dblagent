var stompClient = null;
function connect() {
    var socket = new SockJS('/da-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
    });
}

function subscribe(id){
    $(".chat-box").data("agentId", id);

    stompClient.subscribe('/topic/'+id, function (msg) {
        var currentText = $("#chat-history").val() + "\n" + msg.body;
        $("#chat-history").val(currentText );
    });
    $("#chat-text-area-submit").removeAttr("disabled");

}

function messageAgent(id){
    $(".chat-box").data("agentId", id);

    stompClient.subscribe('/topic/'+id, function (msg) {
        var currentText = $("#chat-history").val() + "\n" + msg.body;
        $("#chat-history").val(currentText );
    });
    $("#chat-text-area-submit").removeAttr("disabled");

}

function send() {
    var id = $(".chat-box").data("agentId");
    stompClient.send("/app/message/"+ id, {}, $("#chat-text-area-submit").val());
    $("#chat-text-area-submit").val("");
}

$(function () {

    $(".chat-box").submit(function (event) {
        event.preventDefault();
        send(1, "test");
    });

});
