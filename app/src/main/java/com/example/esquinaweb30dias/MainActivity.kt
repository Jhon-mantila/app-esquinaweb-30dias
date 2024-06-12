package com.example.esquinaweb30dias

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esquinaweb30dias.data.Entradas
import com.example.esquinaweb30dias.data.entradas
import com.example.esquinaweb30dias.ui.theme.EsquinaWeb30DíasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EsquinaWeb30DíasTheme {
                    EntradasApp()
            }
        }
    }
}

@Composable
fun EntradasApp() {

    Scaffold(
        topBar = {
            EntradaTopAppBar()
        }
    ) { it->
        LazyColumn(contentPadding = it) {
            items(entradas){
                EntradasItem(
                    entrada = it
                )
            }
        }

    }
    //EntradasItem(entrada = Entradas(1,  R.string.title_1, R.string.content_1, R.drawable.ydray))
}
@Composable
fun EntradasItem(
    entrada: Entradas,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )

    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ).padding(10.dp)

    ){
        Column (modifier = Modifier.background(color = color)) {
            EntradaInfo(
                entradaTitle = entrada.title,
                entradaId = entrada.id,
                modifier = Modifier.padding(10.dp))
            EntradaImagen(
                entradaImage = entrada.image,
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .clip(MaterialTheme.shapes.small)
            )
            EntradaItemButtom(
                expanded = expanded,
                onClick = { expanded = !expanded },
                modifier = Modifier
            )
            if (expanded){
                EntradaContent(
                    entradaContent = entrada.content,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp,
                    )
                )
            }

        }
    }
}

@Composable
fun EntradaInfo(
    @StringRes entradaTitle: Int,
    @StringRes entradaId: Int,
    modifier: Modifier = Modifier
){
    Column (modifier = modifier) {
        Text(
            text = "Día: " + entradaId.toString(),
            style = MaterialTheme.typography.labelSmall
            )
        Text(
            text = stringResource(id = entradaTitle),
            style = MaterialTheme.typography.titleLarge
        )
    }
}
@Composable
fun EntradaImagen(
    @DrawableRes entradaImage: Int,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = entradaImage),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun EntradaItemButtom(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun EntradaContent(
    @StringRes entradaContent: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = entradaContent),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntradaTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp),
                    painter = painterResource(R.drawable.logo_esquina_web),
                    contentDescription = null
                )
                Text(text = stringResource(R.string.app_name), style = MaterialTheme.typography.bodyLarge)
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun EntradasPreviewDark() {
    EsquinaWeb30DíasTheme(darkTheme = true) {
        EntradasApp()
    }
}

@Preview(showBackground = true)
@Composable
fun EntradasPreview() {
    EsquinaWeb30DíasTheme(darkTheme = false) {
        EntradasApp()
    }
}