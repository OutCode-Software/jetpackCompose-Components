# Swipeable List example/ reusable

Customizable Slider Component
- Slide left functionality
- Slide right functionality
- Slide left&right functionality
- Can Support Functionality like Slide to edit, Slide to delete, etc.
- Easy plug and play model

## steps to use this component
1. Copy and paste SwipeableItemCell.kt file
2. Add SwipeableItemCell on your List with following parameters
3. Customize parameters as per project need


```
SwipeableItemCell(
number: Int,
onEditClick: (String) -> (Unit),
onDeleteClicked: (String) -> (Unit),
swipeDirection: SwipeDirection
)
```

