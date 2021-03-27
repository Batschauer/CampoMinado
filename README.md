# CampoMinado
Projeto Final da Disciplina de Prática e Desenvolvimento de Sistemas I

Depois de fazer o git clone [...], criar um projeto com base na pasta criada.
Adicionar as JARs do hibernate em Classpath e não Modulepath
Versão do msqlconnector é a 8.0.23

# Política de code review
Sempre que for fazer um commit das alterações para o branch main, será necessário criar um pull request. Essa política impoem que todas as alterações que foram feitas, sejam revisadas por outra pessoa com a finalidade de melhor o código fonte ou prevenir bugs.

# Para criar um pull request
Criar um branch não protegido (utilizar um nome sugestivo para o branch)

	- git checkout -b 'Issue#00'
		- comando git checkout <branch> troca o branch atual para o informado e o parametro [-b] cria o branch caso ele não exista
	- git add *
		- depois de fazer todas as alterações necessárias, adicionar as alterações para stage
	- git commit -m <descrição das alterações realizadas>
		- a mensagem do commit não precisa ser muito grande
	- git push origin Issue#00
		- enviar as alterações do repositório local para o repositório remoto
Criar o pull request no GitHub

	 - Ir na aba Pull requests, e clique em "New pull request"
	 - O branch base mantenha o mesmo, no compare selecione o branch que foi criado
	 - Clicar no "Create pull request"
	 - Selecione o pull request criado, vá até a aba Reviewers, e selecione alguém para revisar (podes informar o nome ou nickname)
	 - Aguardar ser aprovado e realizar o merge do branch para o branch main.


