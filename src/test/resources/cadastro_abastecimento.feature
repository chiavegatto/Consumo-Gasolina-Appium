#encoding: Cp1252
Feature: Consumo de gasolina com desempenho mensal
  Como usu�rio do sistema Consumo de Gasolina
  Desejo cadastrar, alterar, visualizar e excluir Abastecimentos 
  Ent�o conseguirei realizar as opera��es na funcionalidade Abastecimentos.

  Scenario: Cadastrar abastecimento com a data atual do sitema
    Given estou acessando a aplica��o Consumo Gasolina
    When acesso o menu "Adicionar Abastecimento"
    And preencho o abastecimento com os seguintes valores:
      | KM Abastecimento | Quantidade Litros | Valor  |
      | 22950            | 34.14             | 106.86 |
    And pressiono o bot�o "Cadastrar"
    Then deve ser exibido as seguintes informa��es no resumo:
      | KM Litro            | Valor Abastecimentos | Quantidade Abastecimentos | Quantidade Litros  | Quantidade KM |
      | 0.0 KM/Litro(s)/M�s | R$ 106.86            | 1 Vez(es)/M�s             | 34.14 Litro(s)/M�s | 0 KM/M�s      |
@Teste
  Scenario: Cadastrar abastecimento com a data diferente da data atual do sitema
    Given estou acessando a aplica��o Consumo Gasolina
    When acesso o menu "Adicionar Abastecimento"
    And preencho o abastecimento com os seguintes valores:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/05/2015         |
    And pressiono o bot�o "Cadastrar"
    Then deve ser exibido as seguintes informa��es no resumo:
      | KM Litro            | Valor Abastecimentos | Quantidade Abastecimentos | Quantidade Litros  | Quantidade KM |
      | 0.0 KM/Litro(s)/M�s | R$ 106.86            | 1 Vez(es)/M�s             | 34.14 Litro(s)/M�s | 0 KM/M�s      |

  Scenario: Editar um abastecimento cadastrado no sistema
    Given estou acessando a aplica��o Consumo Gasolina
    And possuo o abastecimento cadastrado com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/05/2015         |
    When acesso o menu "Ver Abastecimentos"
    And pressiono no abastecimento com a data "01/05/2015"
    And preencho o abastecimento com os seguintes valores:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 23400            | 44.12             | 140.30 | 02/05/2015         |
    And pressiono o bot�o "Salvar"
    Then deve ser exibido o abastecimento com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor | Data Abastecimento |
      | 23400            | 44.12             | 140.3 | 02/05/2015         |

  Scenario: Excluir um abastecimento cadastrado no sistema
    Given estou acessando a aplica��o Consumo Gasolina
    And possuo o abastecimento cadastrado com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/05/2015         |
    When acesso o menu "Ver Abastecimentos"
    And pressiono longamente no abastecimento com a data "01/05/2015"
    And confirmo a exclus�o do abastecimento
    Then deve ser exibido a mensagem "Nenhum abastecimento cadastrado." na listagem de abastecimentos

  Scenario: Verificar se est� sendo feito o c�lculo do desempenho mensal
    Given estou acessando a aplica��o Consumo Gasolina
    And possuo o abastecimento cadastrado com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/05/2015         |
    When acesso o menu "Adicionar Abastecimento"
    And preencho o abastecimento com os seguintes valores:
      | KM Abastecimento | Quantidade Litros | Valor | Data Abastecimento |
      | 23400            | 44.12             | 140.3 | 02/05/2015         |
    And pressiono o bot�o "Cadastrar"
    Then deve ser exibido as seguintes informa��es no resumo:
      | KM Litro              | Valor Abastecimentos | Quantidade Abastecimentos | Quantidade Litros  | Quantidade KM |
      | 13.18 KM/Litro(s)/M�s | R$ 247.16            | 2 Vez(es)/M�s             | 78.26 Litro(s)/M�s | 450 KM/M�s    |

  Scenario: Verificar o desempenho dos meses anteriores
    Given estou acessando a aplica��o Consumo Gasolina
    And possuo o abastecimento cadastrado com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/02/2015         |
      | 23400            | 44.12             | 140.3  | 15/02/2015         |
    When acesso o menu "Meses Anteriores"
    And Preencho a data inicial "01/02/2015" e data final "28/02/2015"
    And seleciono o tipo de visualiza��o "Desempenho"
    And pressiono o bot�o "Pesquisar"
    Then deve ser exibido as seguintes informa��es no resumo:
      | KM Litro          | Valor Abastecimentos | Quantidade Abastecimentos | Quantidade Litros | Quantidade KM |
      | 13.18 KM/Litro(s) | R$ 247.16            | 2 Vez(es)                 | 78.26 Litros      | 450 KM        |

  Scenario: Verificar se est� listando os abastecimentos dos meses anteriores
    Given estou acessando a aplica��o Consumo Gasolina
    And possuo o abastecimento cadastrado com as seguintes informa��es:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/02/2015         |
      | 23400            | 44.12             | 140.3  | 15/02/2015         |
    When acesso o menu "Meses Anteriores"
    And Preencho a data inicial "01/02/2015" e data final "28/02/2015"
    And seleciono o tipo de visualiza��o "Abastecimento"
    And pressiono o bot�o "Pesquisar"
    Then deve ser exibido os abastecimentos:
      | KM Abastecimento | Quantidade Litros | Valor  | Data Abastecimento |
      | 22950            | 34.14             | 106.86 | 01/02/2015         |
      | 23400            | 44.12             | 140.3  | 15/02/2015         |
