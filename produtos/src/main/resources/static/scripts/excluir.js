class acoes {
    deletar() {
        let getId = document.querySelector('.identificador').value;
        location.href = "/produto/" + getId + "/excluir";
    }

    voltar() {
        let urlVoltar = document.querySelector('.voltar').href;
        window.location.href = urlVoltar;
    }
}

let btn = new acoes();