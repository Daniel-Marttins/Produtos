document.querySelector('.buscar').addEventListener('click', e => {

    alert("Insirar um nome ou codigo\nPara realizar uma consulta!");

    let dados = prompt('Dados:');

    window.location.href = "/buscar/" + dados;
});