package model;
import java.util.List;

public class ZoekObject {
    private List<ZoekResultaten> results;

    public List<ZoekResultaten> getResults() {
        return results;
    }

    public void setResults(List<ZoekResultaten> results) {
        this.results = results;
    }

    public static class ZoekResultaten {
        private int id;
        private String title;
        private List<model.Recept.ExtendedIngredient> extendedIngredients;
        private int likes;
        private int usedIngredientCount;
        private int missedIngredientCount;
        private List<model.Recept.ExtendedIngredient> missedIngredients;
        private List<model.Recept.ExtendedIngredient> usedIngredients;
        private List<model.Recept.ExtendedIngredient> unusedIngredients;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<model.Recept.ExtendedIngredient> getExtendedIngredients() {
            return extendedIngredients;
        }

        public void setExtendedIngredients(List<model.Recept.ExtendedIngredient> extendedIngredients) {
            this.extendedIngredients = extendedIngredients;
        }

        public static class ExtendedIngredient {
            private double amount;
            private int id;
            private String name;
            private String unit;


            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getUsedIngredientCount() {
            return usedIngredientCount;
        }

        public void setUsedIngredientCount(int usedIngredientCount) {
            this.usedIngredientCount = usedIngredientCount;
        }

        public int getMissedIngredientCount() {
            return missedIngredientCount;
        }

        public void setMissedIngredientCount(int missedIngredientCount) {
            this.missedIngredientCount = missedIngredientCount;
        }

        public List<model.Recept.ExtendedIngredient> getMissedIngredients() {
            return missedIngredients;
        }

        public void setMissedIngredients(List<model.Recept.ExtendedIngredient> missedIngredients) {
            this.missedIngredients = missedIngredients;
        }

        public List<model.Recept.ExtendedIngredient> getUsedIngredients() {
            return usedIngredients;
        }

        public void setUsedIngredients(List<model.Recept.ExtendedIngredient> usedIngredients) {
            this.usedIngredients = usedIngredients;
        }

        public List<model.Recept.ExtendedIngredient> getUnusedIngredients() {
            return unusedIngredients;
        }

        public void setUnusedIngredients(List<model.Recept.ExtendedIngredient> unusedIngredients) {
            this.unusedIngredients = unusedIngredients;
        }
    }
}