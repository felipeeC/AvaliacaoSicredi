# Desafio Sicredi - API REST Sessões de votação

# índice
* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Versionamento API](#versionamento-api)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras)


 # Tecnologias utilizadas
 ![spring](https://user-images.githubusercontent.com/65028191/211351881-749ceded-89e5-40fb-a67a-de40f32e64fd.png)
 
 # Descrição do Projeto
 O projeto se baseia em uma API REST que se comunique com uma interface Mobile, o backend da aplicação deve receber informações:
 *Pauta(assunto que será votado);
 *Sessão(Pleito que será votado a pauta desejada);
 *Voto(informações do votante e da escolha "sim" ou "não" para a pauta escolhida);
 
 Ao final receber todos os dados, a aplicação deve contabilizar os votos da sessão selecionada.
 # Versionamento API
 Para um modelo de versionamento de API, utilizaria o mais "dev friendly" modelo path, onde você especifica a versão da API após o domínio da URL, isso além de deixar mais clean a URL, facilita a navegação entre as outras versões, caso necessário.
 ```
HTTP GET
https://api.minhagastronomia/v1/vinhos
 ```
 # Pessoas desenvolvedoras
 ![Design_sem_nome__1_-removebg-preview](https://user-images.githubusercontent.com/65028191/211355227-9cc444d0-c57e-4863-80be-9f85fbad43ae.png)
 Felipe de Moraes Alves
 


