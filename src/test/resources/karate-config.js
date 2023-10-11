function fn() {

    var port = karate.properties['local.server.port']

    return {
        urlBase: 'http://localhost:' + port
    }
}
