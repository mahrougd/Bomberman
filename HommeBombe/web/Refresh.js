function messageHandler(event) {
        
        // On récupère le message envoyé par la page principale
        var messageSent = event.data;
        // On prépare le message de retour
        var messageReturned = "refresh";
        // On renvoit le tout à la page principale
        this.postMessage(messageReturned);
        setTimeout("", 5000);
}

// On définit la fonction à appeler lorsque la page principale nous sollicite
// équivalent à this.onmessage = messageHandler;
this.addEventListener('message', messageHandler, false);
