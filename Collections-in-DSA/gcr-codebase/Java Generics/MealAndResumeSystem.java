interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}

// Generic Meal handler [cite: 95]
class Meal<T extends MealPlan> {
    private final T plan;
    public Meal(T plan) { this.plan = plan; }
    public T getPlan() { return plan; }
}

class MealPlanGenerator {
    // Generic method to validate and generate a meal plan dynamically [cite: 96]
    public static <T extends MealPlan> Meal<T> generatePlan(T structuralPlan) {
        if (structuralPlan == null) {
            throw new IllegalArgumentException("Invalid meal configuration setup.");
        }
        System.out.println("Validating and creating meal profile: " + structuralPlan.getClass().getSimpleName());
        return new Meal<>(structuralPlan);
    }
}