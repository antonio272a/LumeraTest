# 📝 Teste Técnico - Sistema de Gerenciamento de Protocolos  

Este projeto é uma aplicação FullStack composta por um **Backend em Spring Boot** e um **Frontend em Vue 3 + PrimeVue**. O sistema permite o cadastro e listagem de protocolos, garantindo que cada protocolo tenha um número sequencial único e uma data de vencimento calculada automaticamente conforme sua natureza.

---

## 🚀 **Tecnologias Utilizadas**  

### Backend (API)  
- Java 21 
- Spring Boot 3.4.3
- Spring Data JPA  
- H2 Database (Banco de dados em memória)  
- Lombok  

### Frontend  
- Vue 3  
- TypeScript  
- PrimeVue  
- Vue Router  
- Axios  

---

## 📂 **Estrutura do Projeto**  

```
projeto/                # Backend (Spring Boot API)
├── src/main/java/com/lumeratest/
   ├── controller/       # Controllers da API
   ├── model/            # Entidades (Protocolo, Enum)
   ├── repository/       # Repositórios JPA
   ├── service/          # Lógica de negócios
   ├── ProtocoloApplication.java # Arquivo principal da API
├── src/main/resources/   # Configuração do backend
   ├── application.properties  # Configuração do H2 Database
|  |static
|  |  │── frontend/                 # Frontend (Vue 3 + PrimeVue)
|  │   ├── src/                  # Código-fonte do Vue
|  │   │   ├── components/       # Componentes Vue
|  │   │   ├── views/            # Telas
|  │   │   ├── services/         # Serviços de API
|  │   │   ├── router/           # Rotas Vue Router
|  │   │   ├── main.ts           # Arquivo principal do Vue
|  │   │   ├── App.vue           # Componente raiz
|  │   ├── package.json          # Dependências do frontend
│── README.md                 # Instruções do projeto
```

---

## 🛠️ **Configuração e Execução**  

### **1️⃣ Requisitos**  
Antes de iniciar o projeto, certifique-se de ter instalado:  
✅ **Java 21+**  
✅ **Maven 3+**  
✅ **Node.js 18+**  
✅ **NPM ou Yarn**  

### **2️⃣ Executando o Backend**  

1. Compile e execute o backend com Maven na pasta raiz:  
   ```sh
   mvn spring-boot:run
   ```
3. A API estará disponível em [`http://localhost:8080`](http://localhost:8080).  

**Endpoints principais:**  
✅ **Listar Protocolos** (GET) → [`http://localhost:8080/api/protocolos`](http://localhost:8080/api/protocolos)  
✅ **Criar Protocolo** (POST) → [`http://localhost:8080/api/protocolos`](http://localhost:8080/api/protocolos)  
✅ **Banco de Dados (H2 Console)** → [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)  
(JDBC URL: `jdbc:h2:mem:protocolodb` | Usuário: `sa` | Senha: ` `)

---

### **3️⃣ Executando o Frontend**  

1. Navegue até a pasta do frontend:  
   ```sh
   cd src/main/resources/static/frontend
   ```
2. Instale as dependências do Vue:  
   ```sh
   npm install
   ```
3. Inicie o servidor Vue:  
   ```sh
   npm run dev
   ```
4. O frontend estará disponível em [`http://localhost:5173`](http://localhost:5173).  

---

## 🖥️ **Como Usar**  

1. Acesse o frontend em [`http://localhost:5173`](http://localhost:5173).  
2. Utilize o formulário para cadastrar novos protocolos.  
3. A lista de protocolos será atualizada automaticamente após o cadastro.  

