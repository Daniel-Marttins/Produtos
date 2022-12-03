document.querySelector('.atualizar').addEventListener('click', e => {
    document.querySelector('form').submit();
});

document.querySelector('.voltar').addEventListener('click', e => {
    let urlVoltar = document.querySelector('.voltar').href;
    window.location.href = urlVoltar;
});