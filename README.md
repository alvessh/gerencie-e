# 💼 Sistema de Gerenciamento de Estoque (Java Web)

Este projeto está sendo desenvolvido em conjunto com os alunos da turma de **Desenvolvimento Java**, com o objetivo de aplicar conceitos fundamentais de programação orientada a objetos, arquitetura MVC e desenvolvimento de aplicações web utilizando **Java Servlets**.

---

## 🎯 Objetivo

Criar um sistema web simples e funcional para o gerenciamento de estoque de produtos, permitindo:

- 📦 Cadastro de produtos  
- ➕➖ Controle de entradas e saídas de estoque  
- 📋 Visualização e listagem de produtos  
- 📊 Geração de relatórios (em desenvolvimento)  

---

## 🛠️ Tecnologias Utilizadas

- **Java Web (Servlets)** – Backend e geração de páginas HTML via código Java  
- **Apache Tomcat** – Servidor de aplicação  
- **MySQL** – Banco de dados para persistência dos dados  
- **HTML/CSS** – Interface gerada dinamicamente  
- **JDBC** – Conexão com banco de dados  
- **Eclipse IDE** – Ambiente de desenvolvimento  

---

## 🧱 Estrutura do Projeto

```
src/
├── controller/
│   └── ProdutoController.java
├── dao/
│   └── ProdutoDAO.java
├── model/
│   └── Produto.java
├── service/
│   └── ProdutoService.java
├── servlet/
│   └── AppServlet.java
└── util/
    └── Conexao.java

webapp/
├── WEB-INF/
│   └── web.xml
└── assets/
    ├── css/
    └── js/
```

---

## 🧠 Conceitos Abordados

- Programação Orientada a Objetos (POO)
- Arquitetura MVC
- Uso de Servlets como ponto único de entrada (Front Controller)
- Manipulação de dados com DAO e JDBC
- Geração dinâmica de HTML via código Java
- Organização de código por camadas

---

## 👨‍🏫 Projeto Educacional

Este projeto está sendo construído com fins **educacionais**, passo a passo, em sala de aula. Os alunos participam ativamente de todas as etapas:  
🧠 Modelagem → 👨‍💻 Codificação → 🧪 Testes → 🧹 Organização de código.

---

## 🚧 Status do Projeto

> ⚙️ Em desenvolvimento – funcionalidades estão sendo implementadas gradualmente com foco no aprendizado.

---

## 🤝 Colabore

Este projeto é aberto para contribuições dos alunos da turma. Caso queira participar, envie um pull request ou entre em contato durante as aulas. 😄