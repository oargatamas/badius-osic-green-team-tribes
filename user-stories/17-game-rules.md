# 17. Game Rules

## Description

There are things that shouldn't be scattered all over the source code. One of
those things are stats for your troops, or your buildings. Howmuch should they
cost, how powerful they are. How many gold does your mine produce at level 5?
And how much at level 14? These things should not be hardcoded and all over the
place, but should have its home. That's why you need to create rules object, or
multiple different rule objects for things like troops, buildings, etc....

It should look something like this in its simplest form:

```code
const rules = level => ({
  troops: {
    gold: 50 * level,
  },
  buildings: {
    gold: 100 * level,
    townhall: {
      maxLevel: 10,
    },
    mine: {
      generation: 5 + (5 * level),
    },
    farm: {
      generation: 5 + (5 * level),
    },
  },
});
```

Of course, this is JavaScript and you might want to implement your project in
Java, Python or something completely different. In that case, you can be
creative and thing of other formats or ways, how to make a flexible
configuration file capable of storing all your configuration data.

In case, you need to tweak any of the configurated numbers, it is a simple task
of locating it in the right spot and changing it without any need to recompile
anything.

### Testing

- Create ***unit tests*** that should cover both the positive & negative cases
