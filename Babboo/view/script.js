const url = "http://localhost:8080/api/v1/funcionario/contrato"

function hideLoader(){
    document.getElementById("loadding").style.display="none";
}


function show(funcionarios){


    let tab = ``;

    for (let contrato of funcionarios){
        var funcionario = contrato.funcionario

        var tbody = document.getElementById("contratos");
        var novaLinha = tbody.insertRow();

        // Adicionar células à nova linha
        var contratoId = novaLinha.insertCell(0);
        var admissao = novaLinha.insertCell(1);
        var funcionarioNome = novaLinha.insertCell(2);
        var cargo = novaLinha.insertCell(3);
        var departamento = novaLinha.insertCell(4);
        var salarioBruto = novaLinha.insertCell(5)

        contratoId.innerHTML = contrato.contratoId;
        admissao.innerHTML = contrato.admissao;
        funcionarioNome.innerHTML = funcionario.nome;
        cargo.innerHTML = contrato.cargo;
        departamento.innerHTML= contrato.departamento;
        salarioBruto.innerHTML = contrato.salarioBruto


    }
}
async function getAPI(url){
    const response = await fetch(url,{method:"GET"});
    var data = await response.json();
    if(response) hideLoader();
    show(data);

}




getAPI(url)