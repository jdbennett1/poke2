package com.example.poke.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poketable")
data class Pokemon (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val pokemonName: String,
    @ColumnInfo(name = "power")
    val pokemonPower: Double,
    @ColumnInfo(name = "type")
    val pokemonType: String,
    @ColumnInfo(name = "attack1")
    val pokemonAtt1: Double,
    @ColumnInfo(name = "attack2")
    val pokemonAtt2: Double
)

