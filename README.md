# 📜 To-Do list

O **toDoList** é um mini projeto desenvolvido em Java com o objetivo de gerenciar uma lista de tarefas (To-Do list). A aplicação demonstra as operações básicas de CRUD: Criar, Ler, Atualizar e Deletar tarefas.

## 🚀 Funcionalidades

- **➕ Adicionar tarefas (POST /task)**: Permite a criação de uma nova tarefa. O título e a descrição são obrigatórios e passam por uma validação (@Valid) para garantir que não sejam nulos ou vazios. O status (ex: "pendente", "em andamento", "concluído") é opcional; se não for fornecido, o valor padrão "pendente" será utilizado.
- **📋 Listar tarefas e filtrar por status (GET)**: Exibe uma lista de todas as tarefas cadastradas. Esta funcionalidade é dinâmica:
  - Se nenhuma consulta for enviada (/task), retorna todas as tarefas.
  - Se um parâmetro de status for enviado (/task?status=pendente), ele filtra o resultado, retornando apenas as tarefas que correspondem àquele status.
- **🔍 Buscar tarefa por ID (GET /task/{id})**: Permite consultar os detalhes de uma única tarefa específica, identificada pelo seu id. Se o id não for encontrado no banco de dados, a API retorna um erro (neste caso, RuntimeException).
- **✏️ Editar tarefas (PUT /task/{id})**: Atualiza uma tarefa existente, identificada pelo id. A lógica implementada (**updateTaskById**) realiza uma atualização parcial inteligente: ela verifica quais campos (**title, description, status**) foram enviados na requisição e atualiza apenas esses, mantendo os valores originais dos campos que não foram enviados (que vieram como **null**).
- **❌ Remover tarefas (DELETE /task/{id})**: Exclui permanentemente uma tarefa do banco de dados, identificada pelo seu **id**.

## 🧠 Tecnologias Utilizadas

- **Java**

## 🧩 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/leonardokuster/toDoList.git
   ```
2. Entre na pasta do projeto:
   ```bash
   cd toDoList
   ```
3. Compile o projeto:
   ```bash
   javac ToDoListApplication.java
   ```
4. Execute o projeto:
   ```bash
   java ToDoListApplication
   ```

---

👉 Desenvolvido por [leonardokuster](https://github.com/leonardokuster)
