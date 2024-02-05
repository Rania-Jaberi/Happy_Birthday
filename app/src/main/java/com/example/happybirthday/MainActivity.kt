package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //GreetingText( stringResource(R.string.happy_birthday_text), stringResource(
                     //  R.string.signature_text) )
                   GreetingImage(stringResource(R.string.happy_birthday_text), stringResource(
                       R.string.signature_text)  )
                }
            }
        }
    }
}



@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage( stringResource(R.string.happy_birthday_text), stringResource(
            R.string.signature_text))

    }
}
//Remarque : sp est une propriété d'extension pour Int, qui crée une unité sp. De la même manière, vous pouvez utiliser la propriété d'extension .sp pour d'autres types de données, tels que Float et Double.
//Cette fonction GreetingText() affiche du texte dans l'interface utilisateur en appelant la fonction composable Text()
@Composable
fun GreetingText(message : String, from: String, modifier: Modifier = Modifier){
//Pour aligner le message d'accueil au centre de l'écran, ajoutez un paramètre appelé verticalArrangement et définissez-le sur Arrangement.Center
    Column(//Ajoutez une marge intérieure de 8.dp autour de la colonne. Il est recommandé d'utiliser les valeurs de marge intérieure par incréments de 4.dp.
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Center ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            //Pour embellir davantage votre appli, alignez le texte du message d'accueil au centre avec textAlign.
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            //Ajoutez une marge intérieure à la signature et alignez-la à droite.
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }


}
//Chaque fonction composable cdoit accepter un paramètre Modifier facultatif. Les modificateurs indiquent à un élément d'UI comment s'afficher ou se comporter dans sa mise en page parent.
@Composable
fun GreetingImage (message: String, from: String, modifier: Modifier = Modifier) {
//Dans la fonction GreetingImage(), déclarez une propriété val et nommez-la image.
    // Appelez la fonction painterResource() en transmettant la ressource androidparty. Attribuez la valeur renvoyée à la variable image
    val image = painterResource(R.drawable.androidparty)
        Box {
            Image(
                painter = image,
                //Au lieu de définir la description du contenu énoncée à l'utilisateur, vous pouvez définir l'argument contentDescription de l'image sur null pour que TalkBack ignore le composable Image.
                null,
                //vous allez utiliser le paramètre de mise à l'échelle ContentScale.Crop, qui redimensionne les images de manière uniforme pour que leurs proportions en termes de largeur et de hauteur soient égales ou supérieures à celles de l'écran.
                contentScale = ContentScale.Crop,
                //Pour améliorer le contraste de l'application, modifiez l'opacité de l'image de fond.
                alpha = 0.5F
            )

        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .padding(16.dp)

        )

    }}




