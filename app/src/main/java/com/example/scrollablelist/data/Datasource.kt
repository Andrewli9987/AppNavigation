package com.example.scrollablelist.data

import com.example.scrollablelist.R
import com.example.scrollablelist.ui.theme.data.Team

class Datasource {
    fun loadTeams(): List<Team> {
        return listOf(
            Team(R.string.team1, R.drawable.image1),
            Team(R.string.team2, R.drawable.image2),
            Team(R.string.team3, R.drawable.image3),
            Team(R.string.team4, R.drawable.image4),
            Team(R.string.team5, R.drawable.image5),
            Team(R.string.team6, R.drawable.image6),
            Team(R.string.team7, R.drawable.image7),
            Team(R.string.team8, R.drawable.image8),
            Team(R.string.team9, R.drawable.image9),
            Team(R.string.team10, R.drawable.image10),
            Team(R.string.team11, R.drawable.image11),
            Team(R.string.team12, R.drawable.image12),
            Team(R.string.team13, R.drawable.image13),
            Team(R.string.team14, R.drawable.image14),
            Team(R.string.team15, R.drawable.image15),
            Team(R.string.team16, R.drawable.image16)
        )
    }
}

