package org.iesharia.mytabata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.iesharia.mytabata.ui.theme.MytabataTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var intervalCount by remember { mutableIntStateOf(1) }
    var workTime by remember { mutableIntStateOf(0) }
    var restTime by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Intervalos", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "➖",
                fontSize = 24.sp,
                modifier = Modifier.clickable { if (intervalCount > 1) intervalCount-- }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = intervalCount.toString(), fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "➕",
                fontSize = 24.sp,
                modifier = Modifier.clickable { intervalCount++ }
            )
        }
        // Tiempo de Trabajo
        Text(text = "Tiempo de Trabajo", fontSize = 24.sp, modifier = Modifier.padding(top = 24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "➖",
                fontSize = 24.sp,
                modifier = Modifier.clickable { if (workTime > 0) workTime-- }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = String.format(Locale.US, "%02d:%02d", workTime / 60, workTime % 60),
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "➕",
                fontSize = 24.sp,
                modifier = Modifier.clickable { workTime++ }
            )
        }

        // Tiempo de Descanso
        Text(text = "Tiempo de Descanso", fontSize = 24.sp, modifier = Modifier.padding(top = 24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "➖",
                fontSize = 24.sp,
                modifier = Modifier.clickable { if (restTime > 0) restTime-- }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = String.format(Locale.US, "%02d:%02d", restTime / 60, restTime % 60),
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "➕",
                fontSize = 24.sp,
                modifier = Modifier.clickable { restTime++ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MytabataTheme {
        Counter()
    }
}