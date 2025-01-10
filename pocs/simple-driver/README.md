### Build 

```bash
./mvnw clean install 
```

### Result

```Java
Fact{value='When a cats rubs up against you, the cat is marking you with it's scent claiming ownership.'}
Fact{value='A cat’s jaw can’t move sideways, so a cat can’t chew large chunks of food.'}
Fact{value='Baking chocolate is the most dangerous chocolate to your cat.'}
```

### Rationale

1. Lean
2. Minimalist
3. No binary coupling with heavy frameworks
4. Separation of concerns(SOC) between contract and Implementation
5. Fast and easy to build (can add cache, logging, metrics, etc... LATER!)