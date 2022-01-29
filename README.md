# name-grabber

This Clojure application takes a string input and returns just the names in that string, first or last.

## Installation

Download from https://github.com/cmwxyz/name-grabber.

## Usage

The function takes two arguments.

The first argument decides whether to check for first or last names. A nil first argument will check the string for last names. A non-nil first argument will check for first names.

The second argument is the string you want to pull the names out of.

The function returns a collection of strings containing any input words found on the names list. If no matching names are found, it will return an empty collection. The output preserves the casing of the input, but casing is ignored for matching purposes.

## Name Lists

The function can detect approximately 3,000 popular first names and 5,000 popular last names, taken from U.S. census data.

The name lists can be extended (or shrunk), but the current list sizes were chosen because using larger lists creates greater overlap between the first name and last name lists. Larger lists also contain names such as "My" and "Name", which makes the function less useful since the purpose is to eliminate ordinary language from the input string. The names that have been excluded from the name lists are used by only a very small percentage of the U.S. population.

## Examples

$ (-main nil "My name is Tim BROWN green sMITh")

-> ("BROWN" "green" "sMITh")

$ (-main 1 "My name is barbara-Ann the Destroyer")

-> ("barbara" "Ann")

## Limitations

The function treats punctuation in the input as spaces, which means names with punctuation in them will not return matches. D'Angelo, for instance, will be read as "D" and "Angelo" and will not match the original name, even if it's added to the names list. This is a minor limitation, as the current names list, which represents the most popular names, does not contain any names with punctuation. Double first names, however, such as "Peggy Sue" present a challenge this function doesn't currently solve.


## License

Copyright © 2022 

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied: GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any later version, with the GNU Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.
