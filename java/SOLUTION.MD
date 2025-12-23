# SOLUTION TO RPG KATA

## Retrospective after the third iteration

- Are you keeping up with the requirements? Has any iteration been a big challenge?

The healing action by itself was a little bit confusing, since there was no clear example of how it should behave.
For this reason, I decided to postpone the implementation of the Heal action to a follow-up iteration.

The other iterations were clear enough to proceed with confidence.

- Do you feel good about your design? Is it scalable and easily adaptable to new requirements?

I think so. I took this kata as an opportunity to practice modeling Value Objects and applying Composition over Inheritance.
Adding new kinds of characters that can fight would mainly require adding new elements to the `Fighter` enum and a new
factory method.

- Is everything tested? Are you confident in your code?

It might not be the best code in the world, but after following classic TDD, I would say that at least all the happy paths
are covered.

---

## Retrospective after the fifth iteration

- What problems did you encounter?

Adding distance to the fighting algorithm was a bit confusing. I had to think carefully about how to model it, and finally
I decided to include the distance between the source and the target as part of the battle, so I could determine whether
they were in range or not.

Adding non-character elements was also challenging. I considered keeping the `level` attribute for them as well, for example,
to represent whether a character can damage a large tree. A level 10 tree should probably reduce the damage done by a
level 1 character. However, in order to strictly follow the requirements, I decided to leave non-character elements with
only `Health`.

This decision forced me to introduce a new interface to ensure that only certain types of objects can be damaged.

- What have you learned? Any new technique or pattern?

Not really. I mainly focused on Value Objects, removing Primitive Obsession, and using factories, which is my usual way of coding.

- Share your design with others, and get feedback on different approaches.

If anyone wants to help me get rid of the ugly `instanceof` check I had to introduce in the fighting algorithm, I am open
to feedback.

---

## Main thoughts for this kata

- I started this kata to teach a junior developer classic TDD using the Ping Pong Pair Programming approach.
- It is a good exercise to practice building a DSL for tests (Domain Specific Language).
- It is useful for practicing the removal of Primitive Obsession.
- If you review the repository commit by commit, you will find good examples of “extract to class” refactoring techniques.
- No getters — tell, don’t ask!
- I wanted to strictly follow Object Calisthenics, but I did not see a clear benefit in applying it to the `Character` class,
  so I preferred to leave it as it is.
