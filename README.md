# SistemaHospital
Atividade para o final módulo de POO 1, Americanas Futuro Polo Tech Java

Exercício final do módulo de orientação a Objetos 1 em java, Futuro Polo Tech Americanas.

O exercício é composto por 14 Classes ao todo.

A classe principal, chamada main, realiza a instância dos principais objetos e inicia o sistema, fazendo a chamada do método iniciarSistema com todos os parâmetros necessários.

A classe Sistema faz o gerenciamento de todos os menus e chamadas do sistema principal, é ela que vai printar as informações para o usuário na tela.

O sistema possui três objetos principais, o paciente, o atendente e o médico, todos herdando da superClasse Pessoa.

Classe Atendente: Possui dois métodos próprios: retornarStatusDoPaciente -> Vai retornar a situação de determinado Paciente. o método também chama o método verificaPaciente, que retorna o Paciente, caso ele existe. verificaAtendente -> Verifica a existência do Atendente por meio do Atributo cpf.

Classe Medico: gerarDiagostico -> Faz o cadastro dos sintomas do paciente, recebendo os sintomas um a um. método Equals próprio -> Trabalha em conjunto com o método verifica Médico, verificando se o Atributo Crm é igual para os dois médicos comparados.

Classe NeuroCirurgiao: Apenas é um tipo mais específico de médico.

Classe Clinico Geral Apenas é um tipo mais específico de médico.

Classe Paciente: listaSintomas verificaPaciente getPacientes -> Verifica se a lisa de pacientes não está vazia toString

Classe Pessoa: toString() -> para listar os atributos equals() -> Para comparar o cpf de cada pessoa
