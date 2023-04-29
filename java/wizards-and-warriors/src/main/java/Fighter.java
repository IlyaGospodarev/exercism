abstract class Fighter {

        @Override
        public String toString() {
            return "Fighter is a <FIGHTER_TYPE>";
        }

        boolean isVulnerable() {
            return false;
        }

        abstract int damagePoints(Fighter fighter);

    }

    class Warrior extends Fighter {

        @Override
        public String toString() {
            return "Fighter is a Warrior";
        }

        @Override
        int damagePoints(Fighter wizard) {
            return wizard.isVulnerable() ? 10 : 6;
        }
    }

    class Wizard extends Fighter {

        boolean prepareSpell;

        @Override
        public String toString() {
            return "Fighter is a Wizard";
        }

        @Override
        boolean isVulnerable() {
            return !prepareSpell;
        }

        @Override
        int damagePoints(Fighter warrior) {
            return isVulnerable() ? 3 : 12;
        }

        void prepareSpell() {
            prepareSpell = true;
        }
    }
