## Usage
```bash
java -jar dist/clause-resolution.jar "A u B" "A u -B"
```
outputs
```
Clause: A OR B 
Clause: A OR -B 

inference complete
Clause: A 
```
etc
