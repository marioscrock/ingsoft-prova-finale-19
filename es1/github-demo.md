# Git Demo

Vedi cheat sheet https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf

#### Basic commands
```
cd Desktop
mkdir helloworld-git
cd helloworld-git
git init
vim file.txt # Aggiungo testo
git status
git add .
git status

vim ignore.txt # Aggiungo testo
vim .gitignore # Aggiungo ignore.txt
git status
```

Non voglio fare commit di tutto, e.g. file che derivano dalla compilazione o file `.jar`. Posso esplicitare nel file `.gitignore`. Ogni linea in `.gitignore` corrisponde ad un file o un path da ignorare. File `.gitignore` deve essere committato, utile per chi scarica la mia repository.

```
git commit -m "First commit"
git status # .gitignore NOT committed because not staged

git add .
git status
git commit -m "Update .gitignore"

git log
git log --all --graph --oneline --decorate
```

#### Branch
```
git status
git branch update
git checkout update
vim file.txt # Aggiungo testo
git diff
git add .
git commit -m "Update to file.txt"
git checkout master
vim file.txt # No modifiche in questa branch
# Cambiamento rispecchiato nel file system
# Modifico file.txt per creare conflitto
git add . 
git commit -m "Different Update to file.txt"
git log --all --graph --oneline --decorate

git merge update
vim file.txt # RISOLVO e COMMITTO
git branch -d update
git log --all --graph --oneline --decorate
```

#### Remote
Commit on Local repository. Push/Pull on Centralized repository.
```
# Chi crea la repo
git remote add origin <link_repo_from_github>
# Devo fare push ogni branch separatamente
git push -u origin <nome_branch> # Al primo push
# Per il progetto serve solo master

# Altri compagni git clone <link_repo_from_github> # Scarica solo la master branch in locale
