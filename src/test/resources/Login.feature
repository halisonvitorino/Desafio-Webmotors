Feature: Login
  O usuario deseja realizar consulta de um determinado veiculo
  Como usuario cadastrado no site
  O usuario realiza o login no site webmotors

  Scenario Outline: Login com sucesso
    Given O usuario acessa o site webmotors e aciona a opcao Entrar
    When O usuario digita email valido e senha valida e aciona a opcao Entrar
    Then O site apresenta a tela de Consulta ao usuario
