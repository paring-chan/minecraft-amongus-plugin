package com.github.parangee.amongus.blocks

import com.destroystokyo.paper.Title
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class Emergency : Listener {
    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        println("click")
        val locList = arrayOf(
            arrayOf(
                -8, 32, -312
            ), arrayOf(
                -9, 32, -313
            ), arrayOf(
                -8, 32, -314
            ), arrayOf(
                -7, 32, -313
            ), arrayOf(
                -8, 33, -313
            )
        )
        if (e.action == Action.RIGHT_CLICK_BLOCK) {
            e.clickedBlock?.let { b ->
                if (b.type == Material.POLISHED_BLACKSTONE_BUTTON) {
                    val l = b.location
                    val b2 = locList.find {
                        l.blockX == it[0] && l.blockY == it[1] && l.blockZ == it[2]
                    }
                    if (b2 != null) {
                        e.isCancelled = true
                        Bukkit.getOnlinePlayers().forEach { player ->
                            player.teleport(b.location)
                            player.sendTitle(Title("긴-급-회-의(?)", null, 20, 40, 20))
                        }
                    }
                }
            }
        }
    }
}