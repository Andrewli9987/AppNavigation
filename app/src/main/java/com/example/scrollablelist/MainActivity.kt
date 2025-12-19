package com.example.scrollablelist

import android.R.attr.layoutDirection
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.scrollablelist.data.Datasource
import com.example.scrollablelist.ui.theme.ScrollableListTheme
import com.example.scrollablelist.ui.theme.data.Team


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableListTheme {
                TeamApp()
            }
        }
    }
}

@Composable
fun TeamApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            )
    ) {
        TeamList(
            teamlist = Datasource().loadTeams(),

        )
    }
}

@Composable
fun TeamCard(team: Team, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Image(
            painter = painterResource(team.imageResourceId),
            contentDescription = stringResource(team.stringResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = LocalContext.current.getString(team.stringResourceId),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
    }

}

@Composable
fun TeamList(teamlist: List<Team>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(teamlist) { team ->
            TeamCard(
                team = team,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}





