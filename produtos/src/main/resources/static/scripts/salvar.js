document.querySelector('.salvar').addEventListener('click', e => {
    document.querySelector('.formProduto').submit();
});

window.onload = function () {

    if (Math.floor(Math.random() * 100000).toFixed(5).length > 5) {
        document.querySelector('.code').value = Math.floor(Math.random() * 100000);
    }
    else {
        Math.floor(Math.random() * 100000);
    }
}