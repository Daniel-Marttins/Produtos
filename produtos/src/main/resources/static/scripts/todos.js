class acoes {

    atualizar() {
        document.querySelector('form').submit();
    }

    deletar() {
        let getId = document.querySelector(".identificador").value;
        window.location.href = "/produto/" + getId + "/excluir"; 
    }
}

let btn = new acoes();