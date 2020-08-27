package com.github.parangee.amongus.plugin

import com.github.parangee.amongus.blocks.Emergency
import org.bukkit.plugin.java.JavaPlugin

class AmongUS : JavaPlugin() {
    companion object {
        lateinit var plugin : AmongUS
    }

    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(Emergency(), this)
        logger.info("AmongUS plugin enabled")
    }
}