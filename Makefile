GITHUB_REPO ?= agurchu/user-manager    # CHANGE THIS to your actual repo!
GITHUB_ACTOR ?= $(shell whoami)
.PHONY: help build test run clean docker-build docker-run
help:
	@echo "User Manager Makefile"
	@echo ""
	@echo "	 Commands"
	@echo "  build		   Compile the project"
	@echo "	 test		   Run all JUnit tests"
	@echo "  run           Run the main application"
	@echo "  clean         Remove compiled files"
	@echo "  docker-build  Build Docker image"
	@echo "  docker-run    Run Docker container"
	@echo ""

build:
	@echo "Compiling project..."
	javac -d out -cp "src/main/java" src/main/java/agurchu/codewithritmo/usermanager/*.java

test: build
	@echo "Running tests..."
	java -cp "out:src/test/java:/usr/share/java/junit5.jar:/usr/share/java/hamcrest.jar" org.junit.platform.console.ConsoleLauncher --scan-classpath

run: build
	@echo "Running User Manager..."
	java -cp out agurchu.codewithritmo.usermanager.Main

clean:
	@echo "Cleaning up..."
	rm -rf out/

docker-build:
	@echo "Building Docker image..."
	docker build -t user-manager:latest .

	#docker tag user-manager:latest ghcr.io/$(GITHUB_REPO)/user-manager:$(GIT_SHA)
docker-tag:
	@echo "Tagging image for GHCR..."
	docker tag user-manager:latest ghcr.io/$(GITHUB_REPO)/user-manager:latest
docker-login:
	@echo "Logging in to GHCR..."
	@if [ -z "$(GHCR_TOKEN)" ]; then \
		echo "ERROR: GHCR_TOKEN not set. Use: make docker-login GHCR_TOKEN=your-token"; \
		exit 1; \
	fi
	@echo $(GHCR_TOKEN) | docker login ghcr.io -u $(GITHUB_ACTOR) --password-stdin

docker-push: docker-tag
	@echo "Pushing Docker image to GHCR..."
	docker push ghcr.io/$(GITHUB_REPO)/user-manager:latest


docker-run:
	@echo "Running Docker container..."
	docker run --rm -it user-manager:latest

ci-docker:
	@echo "Repo: $(GITHUB_REPOSITORY)"
	@echo "Actor: $(GITHUB_ACTOR)"
	$(MAKE) docker-login docker-build docker-push \
		GHCR_TOKEN=$(GITHUB_TOKEN) \
		GITHUB_REPO=$(GITHUB_REPOSITORY) \
		GITHUB_ACTOR=$(GITHUB_ACTOR)
