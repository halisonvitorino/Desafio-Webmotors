Feature: Buscar Veiculo
  O usuario deseja realizar busca de um determinado veiculo
  Como usuario logado no site, na pagina de busca
  O usuario realiza busca no site webmotors

  Scenario Outline: Buscar veiculo
    Given O usuario logado no site webmotors
    When O usuario escolhe <marca_modelo> do veiculo
    Then Validar <resultado> da consulta do veiculo escolhido

    Examples: 
      | marca_modelo  | resultado     |
      | "hyundai"     | "hyundai"     |
      | "ford fusion" | "ford fusion" |
      | "honda city"  | "honda city"  |
