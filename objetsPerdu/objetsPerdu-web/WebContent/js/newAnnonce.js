
$(document).ready(function() {
    $('#formulaire').on('submit', function(e) {
        e.preventDefault(); 

        var $this = $(this);
 
        var titre = $('#titre').val();
        var contenu = $('#contenu').val();
 
        if(titre === '' || contenu === '') {
            alert('Les champs doivent êtres remplis');
        } else {
            $.ajax({
                url: $this.attr('action'),
                type: 'POST',
                data: $this.serialize(),
                dataType: 'json',
                success: function(json) {
                    if(json.reponse === 'ok') {
                        alert('Tout est bon');
                    } else {
                        alert('Erreur : '+ json.reponse);
                    }
                }
            });
        }
    });
});