# Introduction #

Predefined global values list for non-collision naming in future.

# Details #

GUEST: User (default user account)
  * userId: 0
  * email: null
  * password: null
  * groupId: Group.GUESTS.groupId
  * firstName: "Guest"
  * lastName: "Guest"
  * registeredWhen: null
  * lastLogin: null (<- could be real for statistics in future)

GUESTS: Group (default user group)
  * groupId: 0
  * parentId: 0
  * name: Guests

Session data:
  * "user": User (authentificated account data)