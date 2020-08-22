package io.github.restioson.loopdeloop.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import xyz.nucleoid.plasmid.game.GameWorld;
import xyz.nucleoid.plasmid.game.map.MapTickets;
import xyz.nucleoid.plasmid.game.map.template.MapTemplate;
import xyz.nucleoid.plasmid.game.map.template.TemplateChunkGenerator;

import java.util.ArrayList;
import java.util.List;

public final class LoopDeLoopMap {
    private final MapTemplate template;

    public final List<LoopDeLoopHoop> hoops = new ArrayList<>();

    private BlockPos spawn;

    public LoopDeLoopMap(MapTemplate template) {
        this.template = template;
    }

    public void addHoop(LoopDeLoopHoop hoop) {
        this.hoops.add(hoop);
    }

    public void setSpawn(BlockPos pos) {
        this.spawn = pos;
    }

    public BlockPos getSpawn() {
        return this.spawn;
    }

    public ChunkGenerator asGenerator(MinecraftServer server) {
        return new TemplateChunkGenerator(server, this.template, BlockPos.ORIGIN);
    }

    public MapTickets acquireTickets(GameWorld gameWorld) {
        return MapTickets.acquire(gameWorld.getWorld(), this.template.getBounds());
    }
}
