document.getElementById("template").onchange = function() {
		var reader = new FileReader();

		reader.onload = function(e) {
			// get loaded data and render thumbnail.
			document.getElementById("preview").src = e.target.result;
		};

		// read the image file as a data URL.
		reader.readAsDataURL(this.files[0]);
	
};

function mostra() {

	var text = document.getElementById("list-participantes").value;
	var lines = text.split('\n');
	var countLines = lines.length;
	var linesArray = []
	var titulos = lines[0].split('\t');
	for (i = 0; i < countLines; i++) {
		var participante = lines[i].split('\t');
		var participanteObj = new Object();
		{
			participanteObj.col1 = participante[0];
			participanteObj.col2 = participante[1];
			participanteObj.col3 = participante[2];
			participanteObj.col4 = participante[3];
			participanteObj.col5 = participante[4];
		}
		var participanteString = JSON.stringify(participanteObj);
		participanteString = participanteString.replace("col1", titulos[0])
		participanteString = participanteString.replace("col2", titulos[1])
		participanteString = participanteString.replace("col3", titulos[2])
		participanteString = participanteString.replace("col4", titulos[3])
		participanteString = participanteString.replace("col5", titulos[4])
		participanteObj = JSON.parse(participanteString);
		linesArray.push(participanteObj);
	}

	console.log(linesArray);
}
// });

