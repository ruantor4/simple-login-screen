// Função de login que faz a chamada ao endpoint do back-end
async function login(username, password) {
    try {
        const response = await fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: new URLSearchParams({ username, password }),
        });

        if (response.ok) {
            const message = await response.text();
            alert(message); // Exibe mensagem de sucesso
        } else {
            alert("Invalid credentials"); // Exibe mensagem de erro
        }
    } catch (error) {
        console.error("Error during login:", error);
        alert("An error occurred. Please try again.");
    }
}

// Configura o evento de envio do formulário para chamar a função de login
document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const username = document.querySelector(".username").value;
    const password = document.querySelector(".password").value;
    login(username, password); // Chama a função de login
});