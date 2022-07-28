# desafio-spring-harley

O projeto utiliza a versão Java 11.0.15.1 e Spring 2.7.2.

O projeto embarca duas imagens do docker, do mongodb, e mongo-express. Antes de sua montagem a propriedade volumes da imagem mongo para que utilize o caminho correto de sua máquina.

Feito isso, utilize o comando "docker-compose up -d" para a montagem das imagens. E então é só executar o projeto.

As rotas podem ser utilizadas importando a collection no postman com o arquivo desafio_spring_collection.json na raíz do projeto.
