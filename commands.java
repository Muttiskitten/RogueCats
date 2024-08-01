public class RoguecraftCommand implements CommandExecutor {
    private final RoguecraftPlugin plugin;

    public RoguecraftCommand(RoguecraftPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);

        if (args.length == 0) {
            // Display player's stats or other information
            player.sendMessage("Your level: " + playerData.getLevel());
            player.sendMessage("Your experience: " + playerData.getExperience());
            return true;
        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("skill")) {
            // Handle skill-related commands
            if (args.length == 2 && args[1].equalsIgnoreCase("fireball")) {
                // Cast the fireball skill
                Skill fireball = plugin.getSkillManager().getSkill("Fireball");
                if (fireball != null) {
                    plugin.getCombatManager().castSkill(player, fireball);
                } else {
                    player.sendMessage("The Fireball skill is not registered.");
                }
                return true;
            }
            // Add more skill-related commands here
        }

        // Handle other commands here
        return false;
    }
}
