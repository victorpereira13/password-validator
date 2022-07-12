# Password Validator
A aplicação foi feita com SpringBoot para validar uma senha através de critérios pré-definidos.


## Frameworks

* JUnit - testes unitários
* Mockito - mockar serviços para auxílio no teste unitário

## Estrutura

* adapter - contém a pasta 'rest' onde estão presentes o controller, request, response e errorhandler
* entities - entidade e exception da entidade
* usecase - possui a exception do usecase e o próprio usecase conténdo todas as regras de negócio

* Optei por utilizar aaClean Architecture visando escrever um código com baixo acoplamento, alta coesão, altamente testável e que
  facilita a automação de testes num futuro hipotético

![CleanArch](C:\Users\victo\Pictures\CleanArch.png)

## Funcionamento



### Usecase
No caso de uso estão presentes todas os métodos que irão validar a senha baseada nos critérios pré-definidos, retornando
true se a senha for válida:

![Usecase](C:\Users\victo\Pictures\usecase.png)



