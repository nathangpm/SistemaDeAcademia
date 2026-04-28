# Sistema de Gerenciamento de Academia

API REST desenvolvida com Spring Boot para gerenciamento de uma academia, 
permitindo o controle de alunos, planos, matrículas, treinos e exercícios.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 4.0.4
- Spring Data JPA
- Spring Validation
- H2 Database
- Lombok
- Maven

## Entidades

- **Plano** — tipos de plano disponíveis na academia (Mensal, Trimestral, Anual) com preço e duração
- **Aluno** — cadastro de alunos com dados pessoais como nome, CPF, email e telefone
- **Matrícula** — relacionamento entre aluno e plano, com controle de status (ATIVA, INATIVA, SUSPENSA) e vencimento
- **Treino** — planos de treino vinculados a cada aluno
- **Exercício** — exercícios dentro de cada treino, com informações de séries, repetições e grupo muscular

## Endpoints

### Planos
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /planos | Lista todos os planos |
| GET | /planos/{id} | Busca plano por ID |
| GET | /planos/buscar?nome= | Busca plano por nome |
| GET | /planos/faixa-preco?precoMin=&precoMax= | Busca por faixa de preço |
| POST | /planos | Cria um novo plano |
| PUT | /planos/{id} | Atualiza um plano |
| DELETE | /planos/{id} | Remove um plano |

### Alunos
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /alunos | Lista todos os alunos |
| GET | /alunos/{id} | Busca aluno por ID |
| GET | /alunos/buscar?nome= | Busca aluno por nome |
| GET | /alunos/cpf/{cpf} | Busca aluno por CPF |
| GET | /alunos/paginado | Lista alunos paginado |
| GET | /alunos/buscar/paginado?nome= | Busca por nome paginado |
| GET | /alunos/projection | Lista alunos com projection |
| POST | /alunos | Cadastra um novo aluno |
| PUT | /alunos/{id} | Atualiza um aluno |
| DELETE | /alunos/{id} | Remove um aluno |

### Matrículas
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /matriculas | Lista todas as matrículas |
| GET | /matriculas/{id} | Busca matrícula por ID |
| GET | /matriculas/status/{status} | Busca por status |
| GET | /matriculas/aluno/{alunoId} | Busca matrículas por aluno |
| GET | /matriculas/plano/{planoId} | Busca matrículas por plano |
| GET | /matriculas/vencidas | Lista matrículas vencidas |
| POST | /matriculas | Cria uma nova matrícula |
| PUT | /matriculas/{id} | Atualiza uma matrícula |
| DELETE | /matriculas/{id} | Remove uma matrícula |

### Treinos
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /treinos | Lista todos os treinos |
| GET | /treinos/{id} | Busca treino por ID |
| GET | /treinos/aluno/{alunoId} | Busca treinos por aluno |
| GET | /treinos/buscar?nome= | Busca treino por nome |
| POST | /treinos | Cria um novo treino |
| PUT | /treinos/{id} | Atualiza um treino |
| DELETE | /treinos/{id} | Remove um treino |

### Exercícios
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /exercicios | Lista todos os exercícios |
| GET | /exercicios/{id} | Busca exercício por ID |
| GET | /exercicios/grupo-muscular/{grupoMuscular} | Busca por grupo muscular |
| GET | /exercicios/treino/{treinoId} | Busca exercícios por treino |
| POST | /exercicios | Cria um novo exercício |
| PUT | /exercicios/{id} | Atualiza um exercício |
| DELETE | /exercicios/{id} | Remove um exercício |

## Como Rodar o Projeto

1. Clone o repositório
2. Abra o projeto na sua IDE
3. Rode a aplicação pela classe `SistemaDeAcademiaApplication`
4. Acesse a API em `http://localhost:8080`
5. Acesse o banco H2 em `http://localhost:8080/h2-console`

## Configuração do Banco H2

- **URL:** `jdbc:h2:mem:academia`
- **Usuário:** 
- **Senha:** 

## Equipe

- Nathan Gonçalves Pereira Mendes -rm564666
