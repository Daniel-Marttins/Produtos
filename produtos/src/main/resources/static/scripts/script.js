document.querySelector('.salvar').addEventListener('click', e => {
    window.location.href = "/salvar";
});

document.querySelector('.buscar').addEventListener('click', e => {

    alert("Insirar um nome ou codigo\nPara realizar uma consulta!");

    let dados = prompt('Dados:');

    window.location.href = "/buscar/"+dados;
});

document.querySelector('.todos').addEventListener('click', e => {
    window.location.href = "/buscarTodos";
});

document.querySelector('.atualizar').addEventListener('click', e => {

    alert("Insirar um nome ou codigo\nPara realizar uma atualização!");

    let dados = prompt('Dados:');

    window.location.href = "/produto/atualizar/" + dados;
});

document.querySelector('.deletar').addEventListener('click', e => {

    alert("Insirar um nome ou codigo\nPara realizar uma exclusão!");

    let dados = prompt('Dados:');

    window.location.href = "/excluir/produto/" + dados;
});