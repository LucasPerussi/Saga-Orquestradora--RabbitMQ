const amqp = require('amqplib')
const fila = 'CLIENTE';

amqp.connect({
    host: 'localhost',
    port: 5672,
    username: 'admin',
    password: 123456
}).then((conexao) => {
    // tenta conexao com o servidor rabbitmq
    conexao.createChannel()
    .then((canal) => {
        // se der boa
        canal.consume(fila, (mensagem) => {
            console.log(mensagem.content.toString())
        })
    })
    .catch((error) => {
        //senao pega o erro; 
        console.log(erro)

    })
}).catch((erro) => {
    console.log(erro)
})