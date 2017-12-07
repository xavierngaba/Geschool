$(document).ready(function() {
    $montantInitiale = 0;
    $("#idClasse").change(function (){
        $idClasse = $( "select#idClasse option:checked" ).val();
        $.get('AjaxReglementServlet',{
            idClasse : $idClasse,
            montant : "recherche"
        }, function(reponseText){
            $montantInitiale = reponseText;
            $montantSaisi = $("#montant").val("");
            $("#calcul").text("");
            $("#reste").val("");
            $("#message").text("Les Frais d'insciption pour cette classe s'élève à "+reponseText+" Frs CFA");
        });
    });
    $("#montant").keyup(function(){
        $montantSaisi = $("#montant").val();
        $montantRestant = $montantInitiale - $montantSaisi;
        $("#calcul").text("Reste à payer : "+$montantRestant+" Frs CFA");
        $("#reste").val($montantRestant);
    });
    $("#montant2").keyup(function(){
        //console.log($("#montantinitial").val());
        $montantinitial = $("#montantinitial").val();
        $montantSaisi = $("#montant2").val();
        $montantRestant = $montantinitial - $montantSaisi;
        $("#calcul").addClass("lead");
        $("#calcul").css("font-size: 16px");
        $("#calcul").text("Reste à payer : "+$montantRestant+" Frs CFA");
        $("#reste").val($montantRestant);
    });
});


